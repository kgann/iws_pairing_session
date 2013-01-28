(defproject matches "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
                 [cheshire "5.0.1"]]
  :plugins [[lein-ring "0.7.1"]]
  :ring {:handler matches.handler/app
         :port 3001}
  :jvm-opts ["-Xmx1g"]
  :dev-dependencies [[ring-mock "0.1.2"]])
