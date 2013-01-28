(ns matches.handler
  (:use [cheshire.core :only [generate-string]]
        compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Welcome to the autocomplete api")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
