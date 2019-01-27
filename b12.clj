(ns b12 (:use [overtone.live]) (:require [shadertone.tone :as t]) )

(do
  (defn note->hz [music-note]
    (midi->hz (note music-note)))

  ;Global pulses
  (do
    (defonce master-rate-bus (control-bus))
    (defonce root-trg-bus (control-bus)) ;; global metronome pulse
    (defonce root-cnt-bus (control-bus)) ;; global metronome count

    (defonce b1st_beat-trg-bus (control-bus)) ;; beat pulse (fraction of root)
    (defonce b1st_beat-cnt-bus (control-bus)) ;; beat count

    (defonce b4th_beat-trg-bus (control-bus)) ;; beat pulse (fraction of root)
    (defonce b4th_beat-cnt-bus (control-bus)) ;; beat count

    (defonce b8th_beat-trg-bus (control-bus)) ;; beat pulse (fraction of root)
    (defonce b8th_beat-cnt-bus (control-bus)) ;; beat count

    (defonce b16th_beat-trg-bus (control-bus)) ;; beat pulse (fraction of root)
    (defonce b16th_beat-cnt-bus (control-bus)) ;; beat count

    (defonce b32th_beat-trg-bus (control-bus)) ;; beat pulse (fraction of root)
    (defonce b32th_beat-cnt-bus (control-bus)) ;; beat count

    (def FRACTION_1 "Number of global pulses per beat" 1)
    (def FRACTION_4 "Number of global pulses per beat" 4)
    (def FRACTION_8 "Number of global pulses per beat" 8)
    (def FRACTION_16 "Number of global pulses per beat" 16)
    (def FRACTION_32 "Number of global pulses per beat" 32)

    )

  (do
    (defsynth root-trg [rate 100]
      (out:kr root-trg-bus (impulse:kr (in:kr rate))))

    (defsynth root-cnt []
      (out:kr root-cnt-bus (pulse-count:kr (in:kr root-trg-bus))))

    (defsynth b1st_beat-trg [div FRACTION_1]
      (out:kr b1st_beat-trg-bus (pulse-divider (in:kr root-trg-bus) div)))

    (defsynth b1st_beat-cnt []
      (out:kr b1st_beat-cnt-bus (pulse-count (in:kr b1st_beat-trg-bus))))

    (defsynth b4th_beat-trg [div FRACTION_4]
      (out:kr b4th_beat-trg-bus (pulse-divider (in:kr root-trg-bus) div)))

    (defsynth b4th_beat-cnt []
      (out:kr b4th_beat-cnt-bus (pulse-count (in:kr b4th_beat-trg-bus))))

    (defsynth b8th_beat-trg [div FRACTION_8]
      (out:kr b8th_beat-trg-bus (pulse-divider (in:kr root-trg-bus) div)))

    (defsynth b8th_beat-cnt []
      (out:kr b8th_beat-cnt-bus (pulse-count (in:kr b8th_beat-trg-bus))))

    (defsynth b16th_beat-trg [div FRACTION_16]
      (out:kr b16th_beat-trg-bus (pulse-divider (in:kr root-trg-bus) div)))

    (defsynth b16th_beat-cnt []
      (out:kr b16th_beat-cnt-bus (pulse-count (in:kr b16th_beat-trg-bus))))

    (defsynth b32th_beat-trg [div FRACTION_32]
      (out:kr b32th_beat-trg-bus (pulse-divider (in:kr root-trg-bus) div)))

    (defsynth b32th_beat-cnt []
      (out:kr b32th_beat-cnt-bus (pulse-count (in:kr b32th_beat-trg-bus))))
    )

  (do
    (def r-trg (root-trg master-rate-bus))
    (def r-cnt (root-cnt [:after r-trg]))
    (def b1st-trg (b1st_beat-trg [:after r-trg]))
    (def b1st-cnt (b1st_beat-cnt [:after b1st-trg]))
    (def b4th-trg (b4th_beat-trg [:after r-trg]))
    (def b4th-cnt (b4th_beat-cnt [:after b4th-trg]))
    (def b8th-trg (b8th_beat-trg [:after r-trg]))
    (def b8th-cnt (b8th_beat-cnt [:after b8th-trg]))
    (def b16th-trg (b16th_beat-trg [:after r-trg]))
    (def b16th-cnt (b16th_beat-cnt [:after b16th-trg]))
    (def b32th-trg (b32th_beat-trg [:after r-trg]))
    (def b32th-cnt (b32th_beat-cnt [:after b32th-trg]))
    (control-bus-set! master-rate-bus (* 3 36))
    )
  (do
    (defonce main-g (group "main bus"))
    (defonce early-g (group "early bus" :head main-g))
    (defonce later-g (group "late bus" :after early-g)))

  (do
                                    ;Control

    (defonce mcbus1 (control-bus 2))
    (defonce mcbus2 (control-bus 3))
    (defonce mcbus3 (control-bus 4))

    (defonce cbus1 (control-bus 1))
    (defonce cbus2 (control-bus 1))
    (defonce cbus3 (control-bus 1))
    (defonce cbus4 (control-bus 1))
    (defonce cbus5 (control-bus 1))
    (defonce cbus6 (control-bus 1))
    (defonce cbus7 (control-bus 1))
    (defonce cbus8 (control-bus 1))
    (defonce cbus9 (control-bus 1))
    (defonce cbus10 (control-bus 1))
    (defonce cbus11 (control-bus 1))
    (defonce cbus12 (control-bus 1))
    (defonce cbus13 (control-bus 1))
    (defonce cbus14 (control-bus 1))
    (defonce cbus15 (control-bus 1))
    (defonce cbus16 (control-bus 1))
    (defonce cbus17 (control-bus 1))
    (defonce cbus18 (control-bus 1))
    (defonce cbus19 (control-bus 1))
    (defonce cbus20 (control-bus 1))
    (defonce cbus21 (control-bus 1))
    (defonce cbus22 (control-bus 1))
    (defonce cbus23 (control-bus 1))
    (defonce cbus24 (control-bus 1))
    (defonce cbus25 (control-bus 1))
    (defonce cbus26 (control-bus 1))
    (defonce cbus27 (control-bus 1))
    (defonce cbus28 (control-bus 1))
    (defonce cbus29 (control-bus 1))
    (defonce cbus30 (control-bus 1))
    (defonce cbus31 (control-bus 1))
    (defonce cbus32 (control-bus 1))


    (defonce vcbus1 (control-bus 1))
    (defonce vcbus2 (control-bus 1))
    (defonce vcbus3 (control-bus 1))
    (defonce vcbus4 (control-bus 1))
    (defonce vcbus5 (control-bus 1))
    (defonce vcbus6 (control-bus 1))
    (defonce vcbus7 (control-bus 1))
    (defonce vcbus8 (control-bus 1))
    (defonce vcbus9 (control-bus 1))
    (defonce vcbus10 (control-bus 1))



                                        ;Audio
    (defonce abus1 (audio-bus))
    (defonce abus2 (audio-bus))
    (defonce abus3 (audio-bus))
    (defonce abus4 (audio-bus))
    (defonce abus5 (audio-bus))
    (defonce abus6 (audio-bus))
    (defonce abus7 (audio-bus))
    (defonce abus8 (audio-bus))
    (defonce abus9 (audio-bus))
    (defonce abus10 (audio-bus))
    (defonce abus11 (audio-bus))
    (defonce abus12 (audio-bus))
    (defonce abus13 (audio-bus))
    (defonce abus14 (audio-bus))
    (defonce abus15 (audio-bus)))
  (defonce abus16 (audio-bus))


  (do
    (defonce buffer-32-1 (buffer 32))
    (defonce buffer-32-2 (buffer 32))
    (defonce buffer-32-3 (buffer 32))
    (defonce buffer-32-4 (buffer 32))
    (defonce buffer-32-5 (buffer 32))
    (defonce buffer-32-6 (buffer 32))
    (defonce buffer-32-7 (buffer 32))

    (defonce buffer-64-1 (buffer 64))
    (defonce buffer-64-2 (buffer 64))
    (defonce buffer-64-3 (buffer 64))
    (defonce buffer-64-4 (buffer 64))
    (defonce buffer-64-5 (buffer 64))
    (defonce buffer-64-6 (buffer 64))
    )
)

;(stop)
 (pp-node-tree)
;(kill 247)

 (buffer-write! buffer-64-1 [1 0 2 0 0 0 0 0
                             1 0 4 0 0 0 0 0
                             1 0 0 0 0 0 0 0
                             1 0 0 0 0 0 0 0
                             1 0 0 0 0 0 0 0
                             1 0 0 0 0 0 0 0
                             1 0 0 0 2 0 0 0
                             3 0 5 0 0 0 0 0])


 (buffer-write! buffer-64-1 [1 0 0 0 1 0 0 0
                             1 0 0 0 1 0 0 0
                             1 0 0 0 1 0 0 0
                             1 0 2 0 1 0 0 0
                             1 0 0 0 1 0 0 0
                             1 0 0 0 1 0 0 0
                             1 0 0 0 1 0 0 0
                             2 0 3 0 4 0 0 0])


(defsynth beatBufferReader [beat-buf 0
                            in-bus-ctr 0
                            in-trg-bus 0
                            outbus 0
                            fraction 1
                            del 0]
    (let [tr-in     (pulse-divider (in:kr in-trg-bus) fraction)
          tr-in     (t-delay:kr tr-in del)
          ctr-in    (in:kr in-bus-ctr)
          pls       (buf-rd:kr 1 beat-buf ctr-in)
          pls       (* pls tr-in)]
      (out:kr outbus pls)))

(def kickBufReader (beatBufferReader [:tail early-g]
                         :beat-buf buffer-32-1
                         :in-trg-bus b4th_beat-trg-bus
                         :in-bus-ctr b4th_beat-cnt-bus
                         :outbus cbus1 ))

(ctl kickBufReader
     :beat-buf buffer-64-1
     :in-trg-bus b8th_beat-trg-bus
     :in-bus-ctr b8th_beat-cnt-bus)

(kill kickBufReader)


(defsynth chordBufferReader [chord-buf  0
                             idx-buf    0
                             in-bus-ctr 0
                             outbus     0]
    (let [ctr-in    (in:kr in-bus-ctr)
          fidx      (buf-rd:kr 1 idx-buf ctr-in)
          f1   (buf-rd:kr 1 chord-buf (+ fidx 0))
          f2   (buf-rd:kr 1 chord-buf (+ fidx 1))
          f3   (buf-rd:kr 1 chord-buf (+ fidx 2))
          f4   (buf-rd:kr 1 chord-buf (+ fidx 3))
          ]
      (out:kr outbus [f1 f2 f3 f4])))



(defsynth noteBufferReader [chord-buf  0
                             idx-buf    0
                             in-bus-ctr 0
                             outbus     0]
    (let [ctr-in    (in:kr in-bus-ctr)
          fidx      (buf-rd:kr 1 idx-buf ctr-in)
          f1   (buf-rd:kr 1 chord-buf (+ fidx 0))
          ]
      (out:kr outbus f1)))


                                        ;Kick
(defsynth kick [freq 80
                amp 1
                amp_output 1
                v1 0.001
                v2 0.001
                v3 0.001
                c1 -20
                c2 -8
                c3 -8
                d1 1
                d2 1
                d3 1
                f1 80
                f2 1
                f3 80
                clipVal 0.3
                beat-control-bus 0
                video-control-bus 0
                outbus 0]
    (let [pls       (in:kr beat-control-bus)
          adj       (max 1 pls)
          co-env    (perc v1 d1 f1 c1)
          a-env     (perc v2 d2 adj c2)
          osc-env   (perc v3 d3 f3 c3)
          cutoff    (lpf (pink-noise) (+ (env-gen co-env :gate pls) (* 1 20)))
          sound     (lpf (sin-osc (+ 0 (env-gen osc-env :gate pls) 20)) (* 200 1))
          env       (env-gen a-env :gate pls)
          venv      (env-gen:kr a-env :gate pls)
          _         (out:kr video-control-bus venv)
          output    (*  amp (+ cutoff sound) env)]
      (out outbus (pan2 (* amp_output (clip:ar output clipVal))))))

(def k1 (kick [:tail early-g] :freq 80 :amp 1
              :beat-control-bus cbus1 :outbus 0
              :video-control-bus vcbus1))

(ctl k1 :amp 0.75)

(ctl k1 :freq 90 :amp 1 :amp_output 0.5
     :v1 0.1 :v2 0.01 :v3 0.01
     :c1 -20 :c2 -8 :c3 -8
     :d1 2 :d2 2 :d3 0.5
     :f1 80 :f2 30 :f3 80)


(ctl k1 :freq 40 :amp 0.7 :amp_output 1
     :v1 0.1 :v2 0.01 :v3 0.01
     :c1 -20 :c2 -8 :c3 -8
     :d1 2 :d2 2 :d3 0.5
     :f1 20 :f2 20 :f3 20)

(kill k1)

(stop)
                                        ;Snare

 (buffer-write! buffer-32-1 [1 2 0 0 1 0 0 0
                             1 0 0 0 2 0 0 0
                             1 0 0 0 3 0 0 0
                             1 0 0 0 1 0 0 0])

 (buffer-write! buffer-32-1 [2 0 0 0 1 0 0 0
                             3 0 0 0 1 0 0 0
                             2 0 0 0 1 0 0 0
                             5 0 0 0 1 0 0 0])


 (buffer-write! buffer-32-1 [1 0 0 0 1 0 0 0
                             4 0 0 0 2 0 0 0
                             5 0 0 0 3 0 0 0
                             5 0 0 0 3 0 0 0])


(def snareBufReader (beatBufferReader [:tail early-g]
                         :beat-buf buffer-32-1
                         :in-trg-bus b4th_beat-trg-bus
                         :in-bus-ctr b4th_beat-cnt-bus
                         :outbus cbus2 ))

(pp-node-tree)

(ctl snareBufReader :del 0.0)

(kill snareBufReader)

  (defsynth snare [amp 0.3
                   fraction 1
                   del 0
                   beat-control-bus 0
                   out-bus 0
                   attack 0.01
                   sustain 0.01
                   release 0.1
                   cutoff 2000]
    (let [pls (in:kr beat-control-bus)
          adj (max 1 pls)
          env (env-gen (lin attack sustain (* adj release) (* 0.1 adj)) :gate pls)
          snare (* 3 (pink-noise) (apply + (* (decay env [attack release]) [1 release])))
          snare (+ snare (bpf (* 4 snare) cutoff))
          snare (clip2 snare 1)]
      (out out-bus (pan2 (*  amp snare env)))))

(def snare1 (snare [:tail early-g] :beat-control-bus cbus2))

(ctl snare1 :amp 0.05 :attack 0.01 :sustain 0.02 :release 0.1 )

(ctl snare1 :amp 0.25 :attack 0.01 :sustain 0.02 :release 0.1 :cutoff 100)

(kill snare)

(pp-node-tree)

                                        ;tb303

(buffer-write! buffer-32-2 0 (map note->hz (chord :C1 :7sus2)))

(buffer-write! buffer-32-2 4 (map note->hz (chord :C2 :7sus2)))

(buffer-write! buffer-32-2 8 (map note->hz (chord :C3 :7sus2)))

(buffer-write! buffer-32-2 12 (map note->hz (chord :C4 :7sus2)))

(buffer-write! buffer-32-2 16 (map note->hz (chord :C5 :7sus2)))


(buffer-write! buffer-32-3 [0 0 0 0 1 0 0 0
                            1 0 0 0 1 0 0 0
                            1 0 0 0 1 0 0 0
                            0 0 0 0 1 0 0 0])



(buffer-write! buffer-32-3 [1 0 0 1 1 0 1 0
                            1 0 1 0 1 0 1 0
                            1 0 1 0 1 0 1 0
                            1 1 0 1 1 1 1 1])


(buffer-write! buffer-32-4 [1 1 1 5 4 3 3 1
                            2 2 1 2 1 2 2 2
                            2 2 1 2 1 2 0 4
                            0 1 0 2 3 4 5 6])


(buffer-write! buffer-32-5 [12 12 12 12 12 12 12 12
                            4 4 4 4 4 4 4 4
                            4 4 4 4 4 4 4 4
                            8 8 8 8 8 8 8 8])


                                        ;Mooger


(def tbBufReader (beatBufferReader [:tail early-g]
                         :beat-buf buffer-32-3
                         :in-trg-bus b4th_beat-trg-bus
                         :in-bus-ctr b4th_beat-cnt-bus
                         :outbus cbus3 ))


(def noteBufReader (noteBufferReader  [:tail early-g]   :chord-buf  buffer-32-2
                                       :idx-buf    buffer-32-4
                                       :in-bus-ctr b4th_beat-cnt-bus
                                       :outbus     cbus4))

(def chordBufReader (chordBufferReader :chord-buf  buffer-32-2
                                       :idx-buf    buffer-32-5
                                       :in-bus-ctr b4th_beat-cnt-bus
                                       :outbus     mcbus3))

(kill chordBufReader)

(control-bus-get mcbus3)

(ctl tbBufReader :in-trg-bus b16th_beat-trg-bus
     :in-bus-ctr b4th_beat-cnt-bus)

(ctl noteBufReader :in-trg-bus b16th_beat-trg-bus
     :in-bus-ctr b16th_beat-cnt-bus)


(control-bus-get cbus4)
;(kill noteBufReader)

(pp-node-tree)

  (defsynth tb303
    [beat-control-bus 0 note-bus 0
     wave       1
     r          0.8
     attack     0.01
     decay      0.1
     sustain    0.6
     release    0.01
     cutoff     300
     env-amount 0.01
     amp        10
     fidx       0]
    (let [freqs_in   (in:kr note-bus)
          gate       (in:kr beat-control-bus)
          freq       freqs_in
          adj        (max 1 gate)
          freqs      [freq (* 1.01 freq)]
          vol-env    (env-gen (adsr attack decay sustain release)
                              (line:kr 1 0 (+ attack decay release))
                              :gate gate)
          fil-env    (env-gen (perc))
          fil-cutoff (+ cutoff (* env-amount fil-env))
          waves      (* vol-env
                        [(saw freqs)
                         (pulse freqs 0.5)
                         (lf-tri freqs)])
          selector   (select wave waves)
          filt       (rlpf selector fil-cutoff r)]
      (out 0 (pan2 (* amp filt)))))

(def tb (tb303  [:tail early-g] :beat-control-bus  cbus3 :note-bus cbus4))

(ctl tb :attack 0.01 :sustain 0.0101 :release 0.1 :decay 0.01
     :amp 1 :cutoff 500 :env-amount 0.001)

(ctl tb :attack 0.01 :sustain 0.0101 :release 0.1 :decay 0.01
     :amp 3 :cutoff 50 :env-amount 0.001)

(kill tb)

(stop)
                                        ;Mooger


  (defsynth mooger
    "Choose 0, 1, or 2 for saw, sin, or pulse"
    [beat-control-bus 0 chord-bus 0
     amp  0.3
     osc1 1
     osc2 1
     osc3 1
     osc1-level 1
     osc2-level 1
     osc3-level 1
     cutoff 500
     attack 0.001
     decay 0.3
     sustain 0.99
     release 0.01
     fattack 0.001
     fdecay 0.3
     fsustain 0.99
     frelease 0.01
     sl1 0
     sl2 1
     sl3 2]
    (let [freqs_in   (in:kr chord-bus  3)
          freq1 (select:kr sl1 freqs_in)
          freq2 (select:kr sl2 freqs_in)
          freq3 (select:kr sl3 freqs_in)
          gate       (in:kr beat-control-bus)
          adj        (max 1 gate)
          osc-bank-1 [(saw freq1) (sin-osc freq1) (pulse freq1)]
          osc-bank-2 [(saw freq2) (sin-osc freq2) (pulse freq2)]
          osc-bank-3 [(saw freq3) (sin-osc freq3) (pulse freq3)]
          amp-env    (env-gen (adsr attack decay sustain release) :gate gate)
          f-env      (env-gen (adsr fattack fdecay fsustain frelease) :gate gate)
          s1         (* osc1-level (select osc1 osc-bank-1))
          s2         (* osc2-level (select osc2 osc-bank-2))
          s3         (* osc3-level (select osc3 osc-bank-3))
          filt       (moog-ff (+ s1 s2 s3) (* adj cutoff f-env) 3)]
      (out 0 (pan2 (* amp amp-env filt)))))

(def bg (mooger  [:tail early-g] :beat-control-bus  cbus4 :chord-bus mcbus3 :amp 0.03))

(ctl bg :sl1 0 :sl2 0 :amp 0.05)

(ctl bg :amp 0.05 :osc1 0 :osc2 0 :osc3 1 :osc1-level 0.95 :osc2-level 0.95 :cutoff 10
       :attack 0.001 :decay 0.001 :sustain 0.99 :release 0.001 :beat-control-bus cbus6)

(kill bg)

(pp-node-tree)

                                        ;Vintage bass



(buffer-write! buffer-32-6 [1 1 -1 1 1 0 0 0
                            1 1 0 0 0 0 0 0
                            0 0 0 0 0 0 0 0
                            1 1 -1 1 1 0 0 0])


(buffer-write! buffer-32-6 [1 1 -1 1 1 -1 1 1
                            -1 1 1 -1 1 1 -1 1
                            1 -1 1 1 -1 1 1 -1
                            1 1 -1 1 1 -1 1 1])



(buffer-write! buffer-32-7 [1 1 1 1 1 1 1 1
                            4 4 4 4 4 4 4 4
                            4 4 4 4 0 0 0 0
                            8 8 8 8 0 0 0 0])



(def vbBufReader (beatBufferReader [:tail early-g]
                         :beat-buf buffer-32-6
                         :in-trg-bus b4th_beat-trg-bus
                         :in-bus-ctr b4th_beat-cnt-bus
                         :outbus cbus5))


(def bassNoteBufReader (noteBufferReader  [:tail early-g]   :chord-buf  buffer-32-2
                                       :idx-buf    buffer-32-7
                                       :in-bus-ctr b4th_beat-cnt-bus
                                       :outbus     cbus6))

(control-bus-get cbus6)
  (defsynth vintage-bass
    [beat-control-bus 0
     note-bus 0
     velocity 80
     amp 1
     del 0]
    (let [freqs_in   (in:kr note-bus)
          gate       (in:kr beat-control-bus)
          freq       freqs_in
          adj        (max 1 gate)
          sub-freq (- freq (midicps 12))
          velocity (/ velocity 127.0)
          sawz1    (* 0.275 (saw [freq (* 1.01 freq)]))
          sawz2    (* 0.75 (saw [(- freq 2) (+ 1 freq)]))
          sqz      (* 0.3 (pulse [sub-freq (- sub-freq 1)]))
          mixed    (* 5 (+ sawz1 sawz2 sqz))
          env      (env-gen (adsr 0.1 3.3 0.4 0.8) :gate gate)
          filt     (* env (moog-ff mixed (* velocity env (+ freq 200)) 2.2))
          ]
      (out 0 (* amp filt))))


(def vb (vintage-bass  [:tail early-g] :beat-control-bus  cbus5 :note-bus cbus6))

(ctl vb :amp 0.5 :velocity 2000)

(kill vb)

(odoc moog-ff)

(stop)



                                        ;Video
(defonce beat-cnt-bus-atom_1 (bus-monitor b4th_beat-cnt-bus))


(defonce beat-cnt-bus-atom_3 (bus-monitor b1st_beat-cnt-bus))


(add-watch beat-cnt-bus-atom_1 :cnt (fn [_ _ old new]
                                    (let [])
                                        ;(t/set-dataArray-item 0 (+ (nth (control-bus-get vcbus1) 0) 0.1) )

(t/set-dataArray-item 0 (+ (nth (control-bus-get vcbus1) 0) 0.01) )
; (t/set-dataArray-item 1 (+ (nth (control-bus-get cbus2) 0) 0.1) )
; (t/set-dataArray-item 2 (+ (nth (control-bus-get cbus3) 0) 0.1) )
; (t/set-dataArray-item 3 (+ (nth (control-bus-get cbus4) 0) 0.1) )
(t/set-dataArray-item 5 (+ (nth (control-bus-get cbus6) 0) 0.1) )
                                      ))

(t/start "./b12.glsl" :width 1920 :height 1080 :cams [0 1] :videos ["../videos/jkl.mp4" "../videos/spede.mp4" "../videos/metro.mp4 "  "../videos/uni.mp4"])



(t/set-video-frame-limits 1  51000 52000)

beat-cnt-bus-atom_3

(control-bus-get b1st_beat-cnt-bus)

(nth (control-bus-get b1st_beat-cnt-bus) 0)

(remove-watch beat-cnt-bus-atom_2 :cnt)

(keys (:watches (bean beat-cnt-bus-atom_2)))
