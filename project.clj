(defproject b12 "0.1.0-SNAPSHOT"
    :description "B12"
    :url "https://github.com/Viritystila/b12"
    :license {:name "The Unlicense"
            :url "http://unlicense.org"}
    :injections [(clojure.lang.RT/loadLibrary org.opencv.core.Core/NATIVE_LIBRARY_NAME)]
    :repositories [["Viritystila" "https://github.com/Viritystila/OpenCV/raw/master"]]
    :dependencies [[org.clojure/clojure "1.9.0"]
                    [overtone "0.10.3"][org.viritystila/shadertone "0.2.6-SNAPSHOT"]
                    [org.viritystila/opencv "4.0.1-linux"]
                    [org.viritystila/opencv-native "4.0.1-linux"]])
