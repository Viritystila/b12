(ns b12 (:use [overtone.live]) (:require [shadertone.tone :as t]) )

(do
  (defn note->hz [music-note]
    (midi->hz (note music-note)))

  ;Global pulses
  (do
    (defonce master-rate-bus (control-bus))
    (defonce root-trg-bus (control-bus)) ;; global metronome pulse
    (defonce root-cnt-bus (control-bus)) ;; global metronome count
    (defonce b4th_beat-trg-bus (control-bus)) ;; beat pulse (fraction of root)
    (defonce b4th_beat-cnt-bus (control-bus)) ;; beat count

    (defonce b8th_beat-trg-bus (control-bus)) ;; beat pulse (fraction of root)
    (defonce b8th_beat-cnt-bus (control-bus)) ;; beat count

    (defonce b16th_beat-trg-bus (control-bus)) ;; beat pulse (fraction of root)
    (defonce b16th_beat-cnt-bus (control-bus)) ;; beat count

    (defonce b32th_beat-trg-bus (control-bus)) ;; beat pulse (fraction of root)
    (defonce b32th_beat-cnt-bus (control-bus)) ;; beat count

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
    (defonce abus15 (audio-bus))
    (defonce abus16 (audio-bus))
    )

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


(buffer-write! buffer-32-1 [1 0 0 0 1 0 0 0
                            1 0 0 0 1 0 0 0
                            1 0 0 0 1 0 0 0
                            1 0 0 0 1 0 0 0])

 (buffer-write! buffer-64-1 [4 0 0 1 1 0 1 0
                             1 0 0 0 1 0 1 0
                             5 0 0 0 0 0 0 0
                             1 0 0 0 0 0 0 0
                             1 0 0 0 0 0 0 0
                             1 0 0 0 0 0 0 0
                             1 0 0 0 0 0 0 0
                             1 0 0 0 0 0 0 0])



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
     :in-bus-ctr b4th_beat-cnt-bus)

(kill kickBufReader)

                                        ;Kick
(defsynth kick [freq 80
                amp 1
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
                outbus 0]
    (let [pls       (in:kr beat-control-bus)
          adj       (max 1 pls)
          co-env    (perc v1 d1 f1 c1)
          a-env     (perc v2 d2 adj c2)
          osc-env   (perc v3 d3 f3 c3)
          cutoff    (lpf (pink-noise) (+ (env-gen co-env :gate pls) (* 1 20)))
          sound     (lpf (sin-osc (+ 0 (env-gen osc-env :gate pls) 20)) (* 200 1))
          env       (env-gen a-env :gate pls)
          output    (*  amp (+ cutoff sound) env)]
      (out outbus (pan2 (clip:ar output clipVal)))))

(def k1 (kick :freq 80 :amp 1 :beat-control-bus cbus1 :outbus 0))

(ctl k1 :freq 90 :amp 1
     :v1 1 :v2 0.001 :v3 0.01
     :c1 -20 :c2 -1 :c3 -8
     :d1 1 :d2 1 :d3 1
     :f1 80 :f2 1 :f3 20)


(kill k1)

;Snare
