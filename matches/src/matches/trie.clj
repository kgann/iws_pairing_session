(ns matches.trie
  (:use [clojure.string :only [lower-case]]
        clojure.java.io))

(defn- add-to-trie [trie s]
  (let [lower (lower-case s)]
    (assoc-in trie lower (assoc (get-in trie lower) :val s :terminal true))))

(defn make-trie [coll]
  (reduce add-to-trie {} coll))

(defn make-trie-from-file [filename]
  (with-open [r (reader filename)]
    (make-trie (line-seq r))))

(defn word? [trie s]
  (:terminal (get-in trie (lower-case s)) false))

(defn prefix-matches [trie prefix]
  (remove nil? (map :val (tree-seq map? vals (get-in trie prefix)))))