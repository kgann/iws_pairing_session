(ns matches.handler
  (:use [cheshire.core :only [generate-string]]
        compojure.core
        matches.trie)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(def trie (atom (make-trie-from-file "dictionary.txt")))

(defroutes app-routes
  (GET "/" [] "Welcome to the autocomplete api")
  (GET "/:word" [word] (generate-string {:matches (sort-by count (prefix-matches @trie word))}))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
