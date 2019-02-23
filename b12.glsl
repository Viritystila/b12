uniform float iOvertoneVolume;
uniform float iGlobalBeatCount;
uniform float iActiveColor;
uniform float iA;
uniform float iB;
uniform float iC;
uniform float outt;



//Artifact code adapted from https://www.shadertoy.com/view/Md2GDw
void main(void){
  float it0=iDataArray[0];
  float it1=iDataArray[1];
  float it2=iDataArray[2];
  float it3=iDataArray[3];
  float it5=iDataArray[5];
  vec2 uv = (gl_FragCoord.xy / iResolution.xy);
  vec2 block =floor(gl_FragCoord.xy/vec2(16*1.01*it0));
  vec2 uv_noise = block / vec2(64);
  uv_noise +=floor(vec2(it0*0.3) * vec2(12345.0, 3543.0))/vec2(sqrt(it0));

  float block_thres =pow(fract(it0+123556.0), 2.0)*0.02;
  float line_thres =pow(fract(it0+ 33236), 3.0)* 0.7;

  vec2 uvi=uv;
  uv.y=1.0-uv.y;//*sin(iDataArray[0])*2;

  vec2 uv_r =uv, uv_g=uv, uv_b=uv;

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

  vec4 pf = texture2D(iPreviousFrame, uvi);




  if (v0n.r< block_thres ||
      v1n.g <line_thres){
    vec2 dist = (fract(uv_noise)-0.5)*0.3;
    uv_r +=dist*0.1;
    uv_g +=dist*1.2;
    uv_b +=dist*0.125;
      }

  vec4 glitchText=v0;
  //fragColor.r = texture2D(iVideo0, uv_r).r;
  //	fragColor.g = texture2D(iVideo0, uv_g).g;
  //	fragColor.b = texture2D(iVideo0, uv_b).b;

	// loose luma for some blocks
	if (texture2D(iVideo1, uv_noise).g < block_thres)
		glitchText.rgb = v2.ggg;

        	// discolor block lines
	if (texture2D(iVideo1, vec2(uv_noise.y, 0.0)).b * 2.5 < line_thres)
          glitchText.rgb = vec3(0.0, dot(glitchText.rgb, vec3(1.0)), 0.0);


	// interleave lines in some blocks
	if (texture2D(iVideo0, uv_noise).g * 0.05  < block_thres ||
		texture(iVideo0, vec2(uv_noise.y, 0.0)).g * 2.5 < line_thres) {
		float line = fract(gl_FragCoord.y / 3.0);
		vec3 mask = vec3(3.0, 0.0, 0.0);
		if (line > 0.333){
                  //discard;
                  mask = vec3(0.0, 3.0, 0.0);
                }
		if (line > 0.666)
			mask = vec3(0.0, 0.0, 3.0);

		glitchText.xyz *= mask;
	}

        vec4 bgVid=mix(v4, pf, 1);
const float tau = 6.28318530717958647692;
vec3 wave = vec3(0.0);
//float width = v0.x*((iDataArray[0]*iDataArray[0]*iDataArray[0]*iDataArray[0])/100000000);
float n=10;
 float width=0.11*it0;
for (int i=0; i < 10; i++){
  n=1; //sin(iDataArray[0]);
  float sound =bgVid.x;
  float xymix=mix(uv.y, uv.x, 0);

  float a = 0.1*float(i)*tau/float(n);
  vec3 phase = smoothstep(-1.0,1.5, vec3(cos(a), cos(a-tau/3.0), cos(a-tau*2.0/3.0)));
  wave += phase * smoothstep(width, 0.0, abs(xymix - ((sound*0.5)+0.2)));

  //This shift of uv.x means our index into the sound data also
  //moves along, examining a different part of the audio wave.
  uv.x += 0.4/float(n);
  uv.y -= 0.05*it0;
}
 wave *= 10/float(10); // * iDataArray[0];

  vec4 cf8=vec4(wave, 1);

    //color key

  vec4 bg=mix(bgVid, cf8, it0);
  vec4 fg=v3; //glitchText //v1;

  float squared_distance = dot(fg.rgb, fg.rgb);


  if (squared_distance < it0)
 {
     fg = bg;
 }


  float maxrb = max( fg.r, fg.g);
  float k = clamp( (fg.b-maxrb)*90, 0.0, 1.0);

  float dg = fg.b;
  fg.b = min( fg.b, maxrb);//iDataArray[0]);
    fg += dg - fg.b;


    vec4 bg2=mix(c1, bg, 0.5);
    vec4 cf6=mix(fg, bg, k); //-sin(iDataArray[0]));

    //cf6.b=bg.g;
    //fg.b=fg.r*sin(iDataArray[0])*fg.g;

    gl_FragColor = mix(pf, cf6, 0.1); //cf6; //mix(v2, cf8, sin(iDataArray[0]));

}
