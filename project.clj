(defproject xml-repacker "0.1.0-SNAPSHOT"
  :description "Simple XML getting and repacking"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.3.1"]
                 [http-kit "2.1.18"]
                 [org.clojure/data.xml "0.0.8"]
                 [compojure "1.2.1"]]
  :main xml-repacker.core

  :ring {:handler backend_api.core/app
         :nrepl {:start? true
         :port 9998}}

)