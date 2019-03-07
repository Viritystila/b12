uniform float iOvertoneVolume;
uniform float iGlobalBeatCount;
uniform float iActiveColor;
uniform float iA;
uniform float iB;
uniform float iC;
uniform float outt;

vec2 distortUV(vec2 uv, vec2 nUV, sampler2D nstex ,  float ip1)
{
  vec2 uv_orig=uv;
  float intensity = 0.5*ip1;
  float scale = 0.05;//*ip1;
  float speed = 0.00006;//*ip1;


    nUV.x += sin((iGlobalTime))*speed+2*ip1;
    nUV.y += sin(iGlobalTime)*speed ;
    vec2 noise= texture(nstex, nUV*scale).xy;

    uv += ((-1.0+noise*2))* intensity;

    return mix(uv, uv_orig, 0);;
}

vec2 noiseUV(vec2 uv, float mod1, float mod2){
  vec2 block =floor(gl_FragCoord.xy/vec2(16*1.01*mod2));
  vec2 uv_noise = block / vec2(64);
  uv_noise +=floor(vec2(mod1*0.3) * vec2(12345.0, 3543.0))/vec2(sqrt(mod1));
  return uv_noise;

}

vec4 glitch(vec2 uv_noise, vec2 uv,  vec4 v1In, vec4 v2In, float mod1, sampler2D tex1, sampler2D tex2){
  float block_thres =pow(fract(mod1+12999.0), 2.0)*0.02;
  float line_thres =pow(fract(mod1+ 33336), 3.0)* 0.7;

  vec2 uv_r =uv, uv_g=uv, uv_b=uv;


  if (v1In.r< block_thres ||
      v2In.g <line_thres){
    vec2 dist = (fract(uv_noise)-0.5)*0.3;
    uv_r +=dist*0.1;
    uv_g +=dist*1.2;
    uv_b +=dist*0.125;
      }

  vec4 glitchText=v1In;
	// loose luma for some blocks
	if (texture2D(tex1, uv_noise).g < block_thres)
		glitchText.rgb = v2In.ggg;

        	// discolor block lines
	if (texture2D(tex2, vec2(uv_noise.y, 0.0)).b * 2.5 < line_thres)
          glitchText.rgb = vec3(0.0, dot(glitchText.rgb, vec3(1.0)), 0.0);


	// interleave lines in some blocks
	if (texture2D(tex1, uv_noise).g * 0.05  < block_thres ||
		texture(tex1, vec2(uv_noise.y, 0.0)).g * 2.5 < line_thres) {
		float line = fract(gl_FragCoord.y / 3.0);
		vec3 mask = vec3(3.0, 0.0, 0.0);
		if (line > 0.333){
                  //discard;
                  mask = vec3(100.0, 3.0, 0.0);
                }
		if (line > 0.666)
			mask = vec3(0.0, 0.0, 3.0);

		glitchText.xyz *= mask;
	}

        return glitchText;

}


vec4 blackRemoval(vec4 fg, vec4 bg, float th, float mod1){
  float squared_distance = dot(fg.rgb, fg.rgb);

  if (squared_distance < (mod1*th))
   {
     fg = bg;
   }

  return fg;

}

vec4 waveColors(vec4 v1In, vec2 uv, float mod1, float ns, float w, float lines){
  const float tau = 6.28318530717958647692;
  vec3 wave = vec3(0.0);
  //float width = v0.x*((iDataArray[0]*iDataArray[0]*iDataArray[0]*iDataArray[0])/100000000);
  float n=10;
  float width=w*mod1;
  for (int i=0; i < lines; i++){
    n=1; //sin(iDataArray[0]);
    float sound =v1In.x;
    float xymix=mix(uv.y, uv.x, 0);

    float a = 0.1*float(i)*tau/float(n);
    vec3 phase = smoothstep(-1.0,1.5, vec3(cos(a), cos(a-tau/3.0), cos(a-tau*2.0/3.0)));
    wave += phase * smoothstep(width, 0.0, abs(xymix - ((sound*0.5)+0.2)));

    //This shift of uv.x means our index into the sound data also
    //moves along, examining a different part of the audio wave.
    uv.x += 0.4/float(n);
    uv.y -= 0.05*mod1;
  }
  wave *= 10/float(10); // * iDataArray[0];
  vec4 cf8=vec4(wave, 1);
  return cf8;
}

vec4 chromaKey(vec4 fg, vec4 bg){
  float maxrb = max( fg.r, fg.g);
  float k = clamp( (fg.b-maxrb)*90, 0.0, 1.0);

  float dg = fg.b;
  fg.b = min( fg.b, maxrb);//iDataArray[0]);
    fg += dg - fg.b;

    vec4 cf6=mix(fg, bg, k); //-sin(iDataArray[0]));
    return cf6;
}

//Artifact code adapted from https://www.shadertoy.com/view/Md2GDw
void main(void){
  float it0=iDataArray[0];
  float it1=iDataArray[1];
  float it2=iDataArray[2];
  float it3=iDataArray[3];
  float it4=iDataArray[4];
  float it5=iDataArray[5];
  vec2 uv = (gl_FragCoord.xy / iResolution.xy);

  vec2 uv_noise=noiseUV(uv, it0, it0);

  vec2 uvi=uv;
  uv.y=1.0-uv.y;
  vec2 dsUV=distortUV(uv, uv, iCam0, it0);

  vec4 t0 = texture2D(iChannel0,uv);

  vec4 fftw=texture2D(iFftWave, uv);

  vec4 c0 = texture2D(iCam0,uv);
  vec4 c1 = texture2D(iCam1,uv);
  vec4 c2 = texture2D(iCam2,uv);
  vec4 c3 = texture2D(iCam3,uv);
  vec4 c4 = texture2D(iCam4,uv);

  vec4 v0= texture2D(iVideo0, uv);
  vec4 v1= texture2D(iVideo1, uv);
  vec4 v2= texture2D(iVideo2, uv);
  vec4 v3= texture2D(iVideo3, uv);
  vec4 v4= texture2D(iVideo4, uv);


  vec4 v0n= texture2D(iVideo0, uv_noise);
  vec4 v1n= texture2D(iVideo1, uv_noise);
  vec4 v2n= texture2D(iVideo2, uv_noise);
  vec4 v3n= texture2D(iVideo3, uv_noise);
  vec4 v4n= texture2D(iVideo4, uv_noise);

  vec4 v0d= texture2D(iVideo0, dsUV);
  vec4 v1d= texture2D(iVideo1, dsUV);
  vec4 v2d= texture2D(iVideo2, dsUV);
  vec4 v3d= texture2D(iVideo3, dsUV);
  vec4 v4d= texture2D(iVideo4, dsUV);


  vec4 pf = texture2D(iPreviousFrame, uvi);

        vec4 glitchText=glitch(uv_noise, uv,  v1, v0, it1/60, iVideo0, iVideo1);

        vec4 bgVid=mix(v3, pf, 0);


 vec4 cf8=waveColors(v3, uv, it0, 10, 0.11, 10);
    //color key

 vec4 bg=v1;//mix(pf, cf8, 0);
  vec4 fg=v0; //glitchText //v1;

  fg=blackRemoval(fg, bg, 0.01, 1000*it4);


    vec4 cf6=chromaKey(fg, bg);
    //glitchtexh + pf, it0/4.6 Siivolöf
    vec4 siivobg=mix(v1, v0, 1*it0);
    vec4 codv=mix(siivobg, c1, it0/2);
    gl_FragColor= mix(codv, pf, sqrt(it0)/2.025);//  mix(pf, fg, 0.08); //cf6; //mix(v2, cf8, sin(iDataArray[0]));

}
