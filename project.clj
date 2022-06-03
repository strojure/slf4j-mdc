(defproject com.github.strojure/slf4j-mdc "1.1.1-SNAPSHOT"
  :description "Clojure utility for SLF4J logging system's MDC (Mapped Diagnostic Context)."
  :url "https://github.com/strojure/slf4j-mdc"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :dependencies [[org.clojure/clojure "1.11.1" :scope "provided"]
                 [org.slf4j/slf4j-api "1.7.36"]]

  :profiles {:dev {:dependencies [[org.clojure/tools.logging "1.2.4"]]}})
