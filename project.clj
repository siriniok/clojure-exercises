(defproject clojure-noob "0.1.0-SNAPSHOT"
  :description "Solutions to exercises from http://www.braveclojure.com/"
  :url "https://github.com/siriniok/clojure-exercises"
  :license {:name "Creative Commons Attribution 4.0 International License"
            :url "https://creativecommons.org/licenses/by/4.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :plugins [[lein-exec "0.3.6"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
