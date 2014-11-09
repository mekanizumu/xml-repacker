(ns xml-repacker.core
  (:use [org.httpkit.server :as server]
        [compojure.handler :only [api]]
  )
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.data.xml :as xml]
  )
)


(defn fetch [req]
  (let [xml (xml/parse (:body req))
        ;; DO YOUR FANCY STUFF NOW
        xml-repack (xml/emit-str xml)
        response xml-repack
        ]
    (println "XML" xml-repack)
    {:status  200
       :headers {"Content-Type" "text/xml"}
       :body    response}

  )
)

(defroutes app
  (GET "/" [] "<pre>Nothing to see here</pre>")
  (POST "/fetch" [] fetch)
  (route/not-found "<pre>Page not found.</pre>")
  )

(defn -main [& args]
  (run-server (api #'app) {:port 8080}))