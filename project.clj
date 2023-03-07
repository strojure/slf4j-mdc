(defproject com.github.strojure/slf4j-mdc "1.0.1-7"
  :description "Clojure utility for SLF4J logging system's MDC (Mapped Diagnostic Context)."
  :url "https://github.com/strojure/slf4j-mdc"
  :license {:name "The MIT License" :url "http://opensource.org/licenses/MIT"}

  :dependencies []

  :profiles {:provided {:dependencies [[org.clojure/clojure "1.11.1"]
                                       [org.slf4j/slf4j-api "1.7.36"]]}
             :dev {:dependencies [[org.clojure/tools.logging "1.2.4"]
                                  [ch.qos.logback/logback-classic "1.2.11"]]
                   :source-paths ["doc"]}})
