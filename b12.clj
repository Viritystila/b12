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
    (control-bus-set! master-rate-bus (* 2 36))
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


    (defonce buffer-128-1 (buffer 128))
    (defonce buffer-128-2 (buffer 128))
    (defonce buffer-128-3 (buffer 128))
    (defonce buffer-128-4 (buffer 128))
    (defonce buffer-128-5 (buffer 128))
    (defonce buffer-128-6 (buffer 128))


    (defonce buffer-256-1 (buffer 256))
    (defonce buffer-256-2 (buffer 256))
    (defonce buffer-256-3 (buffer 256))
    (defonce buffer-256-4 (buffer 256))
    (defonce buffer-256-5 (buffer 256))
    (defonce buffer-256-6 (buffer 256))


    )
)

;(stop)
 (pp-node-tree)
;(kill 247)

;siivolöf
 (buffer-write! buffer-64-1 [1 2 6 1 2 2 3 5
                             1 2 3 1 4 2 2 1
                             1 2 6 1 2 2 3 5
                             1 2 3 1 4 2 1 1
                             1 2 6 1 2 2 3 5
                             1 2 3 1 4 2 2 1
                             1 2 6 1 2 2 3 5
                             3 2 3 4 6 7 5 0])


;siivolöf
 (buffer-write! buffer-64-1 [6 1 3 1 2 2 3 2
                             5 2 3 1 4 2 2 1
                             6 2 3 1 2 2 3 2
                             5 2 3 1 4 2 1 1
                             6 2 3 1 2 2 3 2
                             5 2 3 1 4 2 2 1
                             6 2 3 1 2 2 3 2
                             3 2 3 4 5 6 5 1])


(buffer-write! buffer-64-1 [ 2 0 0 0 2 0 0 0
                             2 0 0 0 2 0 0 0
                             2 0 0 0 2 0 0 0
                             2 0 0 0 2 0 0 0
                             2 0 0 0 2 0 0 0
                             2 0 0 0 2 0 0 0
                             2 0 0 0 2 0 0 0
                             2 0 3 0 4 0 0 0])


(buffer-write! buffer-64-1 [ 2 0 2 0 0 0 0 0
                             2 0 0 0 2 0 0 0
                             3 0 4 0 0 0 0 0
                             3 0 0 0 5 0 0 0
                             2 0 0 0 0 0 0 0
                             3 0 0 0 0 0 0 0
                             4 0 0 0 0 0 0 0
                             5 0 0 0 0 0 0 0])


(buffer-write! buffer-256-1 [2 0 2 0 2 0 0 0
                             2 0 2 0 2 0 0 0
                             2 0 2 0 2 0 0 0
                             2 0 2 0 2 0 0 0
                             2 0 2 0 2 0 0 0
                             2 0 2 0 2 0 0 0
                             2 0 0 0 2 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 2 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 2 0 0 0
                             0 0 0 0 2 0 2 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 2 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0
                             2 0 0 0 0 0 0 0])



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
     :in-trg-bus b4th_beat-trg-bus
     :in-bus-ctr b8th_beat-cnt-bus)

                                        ;Hapsiainen

(ctl kickBufReader
     :beat-buf buffer-256-1
     :in-trg-bus b4th_beat-trg-bus
     :in-bus-ctr b4th_beat-cnt-bus)


(kill kickBufReader)

(pp-node-tree)

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
          output    (*  amp (+ cutoff sound) env)
          output    (free-verb output 0.1 0.3 0.1)]
      (out outbus (pan2 (* amp_output (clip:ar output clipVal))))))

(def k1 (kick [:tail early-g] :freq 80 :amp 1
              :beat-control-bus cbus1 :outbus 0
              :video-control-bus vcbus1))

(ctl k1 :amp 0.0)

(ctl k1 :freq 90 :amp 1 :amp_output 0.5
     :v1 0.1 :v2 0.01 :v3 0.01
     :c1 -20 :c2 -8 :c3 -8
     :d1 2 :d2 2 :d3 0.5
     :f1 80 :f2 30 :f3 80)


;uni
(ctl k1 :freq 40 :amp 0.5 :amp_output 1
     :v1 0.1 :v2 0.01 :v3 0.01
     :c1 -20 :c2 -8 :c3 -8
     :d1 2 :d2 2 :d3 0.5
     :f1 20 :f2 20 :f3 20)

;Hapsiainen
(ctl k1 :freq 180 :amp 0.5 :amp_output 1
     :v1 0.01 :v2 0.11 :v3 0.1
     :c1 2 :c2 -11 :c3 -2
     :d1 2 :d2 2 :d3 4.5
     :f1 100 :f2 140 :f3 30)


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
                             3 0 3 0 3 0 0 0])


(def snareBufReader (beatBufferReader [:tail early-g]
                         :beat-buf buffer-32-1
                         :in-trg-bus b4th_beat-trg-bus
                         :in-bus-ctr b4th_beat-cnt-bus
                         :outbus cbus2 ))

(ctl snareBufReader :beat-buf buffer-256-1 :in-bus-ctr b4th_beat-cnt-bus)

(pp-node-tree)

(ctl snareBufReader :del 0.00)

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

(ctl snare1 :amp 1.00 :attack 0.01 :sustain 0.02 :release 0.1 )

(ctl snare1 :amp 0.35 :attack 0.01 :sustain 0.02 :release 0.1 :cutoff 10)

(kill snare)

(pp-node-tree)

                                        ;tb303
(do
  (buffer-write! buffer-32-2 0 (map note->hz (chord :C1 :minor)))

  (buffer-write! buffer-32-2 4 (map note->hz (chord :C2 :minor)))

  (buffer-write! buffer-32-2 8 (map note->hz (chord :C3 :minor)))

  (buffer-write! buffer-32-2 12 (map note->hz (chord :C4 :minor)))

  (buffer-write! buffer-32-2 16 (map note->hz (chord :C5 :minor))))


(buffer-write! buffer-32-3 [0 0 0 0 1 1 0 0
                            1 0 0 0 1 0 0 0
                            1 0 0 0 1 0 0 0
                            0 0 0 0 1 0 0 0])



(buffer-write! buffer-32-3 [0 0 0 0 1 0 0 0
                            1 0 0 0 0 0 0 0
                            1 0 0 0 0 0 0 0
                            0 0 0 0 1 0 0 0])


;Hapsiainen tb303

(buffer-write! buffer-32-3 [1 0 1 0 1 0 1 0
                            1 0 1 0 1 0 1 0
                            1 0 1 0 1 0 1 0
                            1 0 1 0 1 0 1 0])



(buffer-write! buffer-32-3 [1 0 1 1 1 0 1 0
                            1 0 1 0 1 0 1 0
                            1 0 1 0 1 0 1 0
                            1 1 0 0 1 1 1 0])


(buffer-write! buffer-32-3 [0 1 0 2 0 1 0 0
                            0 1 0 3 0 1 0 0
                            0 1 0 4 0 1 0 0
                            0 1 0 3 0 1 0 0])


(buffer-write! buffer-32-3 [1 1 1 2 1 1 1 1
                            1 1 1 3 1 1 1 1
                            1 1 1 4 1 1 1 1
                            1 1 1 3 1 1 1 1])


;Äääniaalto 2
(buffer-write! buffer-32-4 [1 1 1 5 4 3 3 1
                            8 2 1 2 1 2 2 2
                            12 2 1 2 1 2 0 4
                            8 12 0 16 12 8 8 6])


(buffer-write! buffer-32-4 [1 1 1 5 2 3 3 1
                            3 2 1 2 2 2 2 2
                            1 2 1 2 3 2 0 4
                            8 1 0 1 2 8 10 6])

; ääniaalto 1
(buffer-write! buffer-32-4 [0 1 1 2 0 2 0 2
                            0 1 1 2 0 2 0 2
                            0 1 1 2 0 2 0 2
                            0 1 1 2 0 2 0 2])

;Ääniaalto 2
(buffer-write! buffer-32-4 [1 2 5 2 4 4 0 4
                            1 2 5 2 4 4 0 4
                            1 3 5 2 4 4 0 4
                            1 2 5 2 4 4 0 4])

                                        ;ääniaalto 3

(buffer-write! buffer-32-4 [18 17 16 14 13 12 10 9
                            8 6 5 4 2 1 0 1
                            2 4 5 6 8 9 10 12
                            13 14 16 17 18 0 1 2])


(buffer-write! buffer-64-2 [16 16 16 16 16 16 16 16
                            12 13 14 14 14 14 14 14
                            10 10 10 10 10 10 10 9
                            8 8 8 8 8 0 0 0
                            0 0 0 0 0 0 0 0
                            0 0 0 0 4 4 4 4
                            2 2 2 2 8 8 8 8
                            9 9 9 10 10 12 13 14])


;Hapsiainen
(buffer-write! buffer-32-5 [12 12 12 12 12 12 12 12
                            9 9 9 9 8 8 8 8
                            16 16 16 16 16 16 16 16
                            14 14 14 14 13 13 13 13])


(buffer-write! buffer-32-5 [0 0 0 0 0 0 0 0
                            1 1 1 1 2 2 2 2
                            4 4 4 4 5 5 5 5
                            2 2 2 2 2 2 2 2])

(buffer-write! buffer-64-3 [12 12 12 12 12 12 12 12
                            9 9 9 9 8 8 8 8
                            16 16 16 16 16 16 16 16
                            14 14 14 14 13 13 13 13
                            12 12 12 12 12 12 12 12
                            10 10 9 9 8 8 6 6
                            4 4 4 4 5 5 5 5
                            2 2 2 2 4 4 8 8])


(buffer-write! buffer-64-3 [10 10 10 10 10 10 10 10
                            9 9 9 9 8 8 8 8
                            12 12 12 12 12 12 12 12
                            10 10 10 10 10 10 10 10
                            12 12 12 12 8 8 8 8
                            9 9 9 9 9 9 9 9
                            4 4 4 4 5 5 5 5
                            4 4 4 4 8 8 8 8])

                                        ;Mooger


(def tbBufReader (beatBufferReader [:tail early-g]
                         :beat-buf buffer-32-3
                         :in-trg-bus b4th_beat-trg-bus
                         :in-bus-ctr b4th_beat-cnt-bus
                         :outbus cbus3 ))



(kill tbBufReader)

(def noteBufReader (noteBufferReader  [:tail early-g]   :chord-buf  buffer-32-2
                                       :idx-buf    buffer-32-4
                                       :in-bus-ctr b4th_beat-cnt-bus
                                       :outbus     cbus4))

(ctl noteBufReader :idx-buf buffer-32-4)

(def chordBufReader (chordBufferReader :chord-buf  buffer-32-2
                                       :idx-buf    buffer-32-5
                                       :in-bus-ctr b4th_beat-cnt-bus
                                       :outbus     mcbus3))

(ctl chordBufReader :in-bus-ctr b4th_beat-cnt-bus :idx-buf buffer-64-3)

(kill chordBufReader)

(control-bus-get mcbus3)

;Hapsiainen
(ctl tbBufReader :in-trg-bus b4th_beat-trg-bus
     :in-bus-ctr b4th_beat-cnt-bus :beat-buf buffer-32-3)

(ctl noteBufReader :in-trg-bus b32th_beat-trg-bus
     :in-bus-ctr b32th_beat-cnt-bus)


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
     fidx       0
     ctrl-output 0]
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
          filt       (rlpf selector fil-cutoff r)

          ctrl-env    (env-gen:kr (adsr attack decay sustain release)
                              (line:kr 1 0 (+ attack decay release))
                              :gate gate)
          _          (out:kr ctrl-output ctrl-env)
          ]
      (out 0 (pan2 (* amp filt)))))

(def tb (tb303  [:tail early-g] :beat-control-bus  cbus3 :note-bus cbus4 :ctrl-output vcbus3))

(ctl tb :attack 0.01 :sustain 1.0101 :release 0.3 :decay 0.11
     :amp 1 :cutoff 1500 :env-amount 0.001)

(ctl tb :attack 0.001 :sustain 1.101 :release 1.6 :decay 0.01
     :amp 0.6 :cutoff 100 :env-amount 0.01)

(kill tb)

(pp-node-tree)

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
     sl3 2
     ctrl-output 0]
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
          ctrl-amp-env    (env-gen:kr (adsr attack decay sustain release) :gate gate)
         ; _          (out:kr ctrl-output ctrl-amp-env)
          f-env      (env-gen (adsr fattack fdecay fsustain frelease) :gate gate)
          ctrl-f-env (env-gen:kr (adsr fattack fdecay fsustain frelease) :gate gate)
          _          (out:kr ctrl-output (* ctrl-f-env))
          s1         (* osc1-level (select osc1 osc-bank-1))
          s2         (* osc2-level (select osc2 osc-bank-2))
          s3         (* osc3-level (select osc3 osc-bank-3))
          filt       (moog-ff (+ s1 s2 s3) (* cutoff f-env) 3)]
      (out 0 (pan2 (* amp amp-env filt)))))

(def bg (mooger  [:tail early-g] :beat-control-bus  cbus3 :chord-bus mcbus3 :amp 0.03 :ctrl-output vcbus4))

;hapsiainen
(ctl bg :sl1 0 :sl2 1 :amp 0.2 :release 1.1 :cutoff 1000 :osc1 0 :osc2 1 :osc3 2 :attack 0.001 :decay 0.09
     :sustain 0.001 :fattack 0.01 :fsustain 0.1 :frelease 1.965)

(ctl bg :amp 1.0 :osc1 0 :osc2 0 :osc3 0 :osc1-level 0.95 :osc2-level 0.95 :cutoff 4000
       :attack 0.022 :decay 1.091 :sustain 0.0099 :release 1.001 :beat-control-bus cbus3)

 (ctl bg :amp 0.00)
(kill bg)

(control-bus-get vcbus4)

(pp-node-tree)

                                        ;Vintage bass



(buffer-write! buffer-32-6 [1 4 1 1 5 1 1 1
                            1 1 1 1 3 1 1 1
                            1 2 1 2 3 1 1 1
                            1 4 1 2 5 1 1 1])


(buffer-write! buffer-32-6 [1 1 -1 1 1 -1 1 1
                            -1 1 1 -1 1 1 -1 1
                            1 -1 1 1 -1 1 1 -1
                            1 1 -1 1 1 -1 1 1])



(buffer-write! buffer-32-7 [4 4 4 1 8 8 2 1
                            1 1 1 1 1 1 1 1
                            8 8 8 1 8 8 8 1
                            1 1 1 1 1 1 1 1])



(def vbBufReader (beatBufferReader [:tail early-g]
                         :beat-buf buffer-32-6
                         :in-trg-bus b4th_beat-trg-bus
                         :in-bus-ctr b4th_beat-cnt-bus
                         :outbus cbus5))

(ctl vbBufReader :in-trg-bus b8th_beat-trg-bus
     :in-bus-ctr b16th_beat-cnt-bus)


(def bassNoteBufReader (noteBufferReader  [:tail early-g]   :chord-buf  buffer-32-2
                                       :idx-buf    buffer-32-7
                                       :in-bus-ctr b4th_beat-cnt-bus
                                       :outbus     cbus6))

(kill bassNoteBufReader)

(control-bus-get cbus6)
  (defsynth bassg
    [beat-control-bus 0
     note-bus 0
     velocity 80
     amp 1
     del 0
     control-output 0]
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
          env      (env-gen (adsr (* adj 0.1) (* 1 3.3) 0.4 0.8) :gate gate)
          env-ctrl (env-gen:kr (adsr (* adj 0.1) (* 1 3.3) 0.4 0.8) :gate gate)
          _        (out:kr control-output env-ctrl)
          filt   (* env (moog-ff mixed (* velocity env (+ freq 200)) 2.2))]

      (out 0 (* amp filt))))




(def vb (bassg  [:tail early-g] :beat-control-bus  cbus5 :note-bus cbus6 :control-output vcbus5))

(ctl vb :amp 1.0  :velocity 2000)

(kill vb)

(odoc moog-ff)

(stop)

(pp-node-tree)

(control-bus-set! cbus6 0)


                                        ; Free synth

(defsynth supersaw [note-bus 0 gate-bus 0 out-bus 0 ctrl-output 0 leak 0.25 cutoff 100 amp 1]
  (let [gate   (in:kr gate-bus)
        freq   (in:kr note-bus)
        input  (lf-saw freq)
        shift1 (lf-saw 4)
        shift2 (lf-saw 7)
        shift3 (lf-saw 5)
        shift4 (lf-saw 2)
        comp1  (> input shift1)
        comp2  (> input shift2)
        comp3  (> input shift3)
        comp4  (> input shift4)
        output (+ (- input comp1) (- input comp2) (- input comp3) (- input comp4))
        output (- output input)
        output (leak-dc:ar (* output leak))
        output (lpf output cutoff)
        opctr  (a2k output)
        _      (out:kr ctrl-output (* freq 1))]
    (out out-bus (pan2  (* amp output)))))

(odoc a2k)

(def ss1 (supersaw :note-bus cbus4 :gate-bus 1 :outbus 0 :ctrl-output vcbus2 :leak 0.25 :amp 0.2))

(ctl ss1 :amp 1 :leak 0.25 :note-bus cbus4 :cutoff 100)

(kill ss1)

(pp-node-tree)

(kill 115)

(control-bus-get vcbus2)



                                        ;OSC
(def oscserver (osc-server 3333 "osc-clj"))
(def client (osc-client "localhost" 3333))
(zero-conf-on)
(java.net.InetAddress/getLocalHost)


(osc-handle oscserver "/play2" (fn [msg] (println "MSG: " msg)))
(osc-listen oscserver (fn [msg] (println msg)) :debug)
(osc-send client "/play2" "i" 10)

(osc-rm-listener oscserver :debug)
(osc-rm-listener oscserver :debug)

(osc-handle oscserver "/play2" (fn [msg] (println (nth (:args msg) 8))))



(definst foo [freq 440] (sin-osc freq))

(defn control-foo
 [val]
  (let [val (* 1  val)
        _  (control-bus-set! cbus32 val)]
      (ctl foo :freq val)))

(osc-handle oscserver "/play2" (fn [msg] (control-foo (nth (:args msg) 6))))

(foo)

(control-bus-get vcbus5)

(pp-node-tree)

(kill 38)

(stop)
                                        ;video


(defonce beat-cnt-bus-atom_1 (bus-monitor b4th_beat-cnt-bus))


(defonce beat-cnt-bus-atom_2 (bus-monitor b1st_beat-cnt-bus))

(defonce cbus32-atom_3 (bus-monitor cbus32))

beat-cnt-bus-atom_1

(add-watch beat-cnt-bus-atom_2 :cnt (fn [_ _ old new]
                                    (let [])
                                        ;(t/set-dataArray-item 0 (+ (nth (control-bus-get vcbus1) 0) 0.1) )

 ; (t/set-fixed-buffer-index 1 :ff (nth (control-bus-get cbus32) 0))
                                      (t/set-fixed-buffer-index 1 :inc)
                                      (t/set-dataArray-item 0 (+ (nth (control-bus-get vcbus1) 0) 0.01) )
                                      (t/set-dataArray-item 1 (+ (nth (control-bus-get vcbus2) 0) 0.01) )
                                      (t/set-dataArray-item 2 (+ (nth (control-bus-get vcbus3) 0) 0.01) )
                                      (t/set-dataArray-item 3 (+ (nth (control-bus-get vcbus4) 0) 0.0021) )
                                      (t/set-dataArray-item 4 (+ (nth (control-bus-get vcbus5) 0) 0.0021) )
                                      (t/set-dataArray-item 5 (+ (nth (control-bus-get cbus6) 0) 0.1) )
                                      ))

                                        ;ääniaalto 9_3_2019 videot
(do
  (t/start "./b12.glsl" :width 1920 :height 1080 :cams [0 1] :videos ["../videos/uni_fixed.mp4" "../videos/Siivolöf.mp4"])

                                        ;Spede: 5100

                                        ;Sihvolöf: 470,7000, 10800
  (t/set-video-play 1)

  (t/bufferSection 1 0 470)

  (t/set-video-fixed 1 :fw)

  )

(do
                                        ;ääniaalto 6400, 6800, 13100
  (t/bufferSection 0 0 6400)

  (t/set-active-buffer-video 0 0)

  (t/set-video-fixed 0 :fw)

  )


(t/set-video-play 0)

(t/bufferSection 3 0 300)

(t/set-video-fixed 3 :bw)


;Tvshop 2 frames: 1100, 4100, 15100,20500,  25100
(t/bufferSection 4 0 20100)

(t/bufferSection 4 1 20440)

(t/set-active-buffer-video 4 0)

(t/set-video-fixed 4 :fw)

;(t/post-start-video "../videos/spede.mp4" 1)

(t/release-cam-textures 2)

(t/set-video-play 1)

(t/set-video-play 4)

(t/bufferSection 3 0 6500)

(t/set-video-fixed 3 :fw)


(t/post-start-cam 1)


(t/set-video-frame-limits 1  51000 52000)

(t/toggle-recording "/dev/video1")

(control-bus-get b1st_beat-cnt-bus)

(nth (control-bus-get b1st_beat-cnt-bus) 0)

(remove-watch beat-cnt-bus-atom_1 :cnt)

(keys (:watches (bean beat-cnt-bus-atom_1)))

(stop)
