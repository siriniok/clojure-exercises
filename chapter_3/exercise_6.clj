;;;; Create a function that generalizes symmetrize-body-parts and
;;;; the function you created in Exercise 5. The new function should take
;;;; a collection of body parts and the number of matching body parts to add.
;;;; If you’re completely new to Lisp languages and functional programming,
;;;; it probably won’t be obvious how to do this. If you get stuck, just move
;;;; on to the next chapter and revisit the problem later.

(ns exercise-5 (:use clojure.pprint))

(def asym-body-parts [{:name "head" :size 3}
                       {:name "eye-1" :size 1}
                       {:name "ear-1" :size 1}
                       {:name "mouth" :size 1}
                       {:name "nose" :size 1}
                       {:name "neck" :size 2}
                       {:name "shoulder-1" :size 3}
                       {:name "upper-1-arm" :size 3}
                       {:name "chest" :size 10}
                       {:name "back" :size 10}
                       {:name "forearm-1" :size 3}
                       {:name "abdomen" :size 6}
                       {:name "kidney-1" :size 1}
                       {:name "hand-1" :size 2}
                       {:name "knee-1" :size 2}
                       {:name "thigh-1" :size 4}
                       {:name "lower-leg-1" :size 3}
                       {:name "achilles-1" :size 1}
                       {:name "foot-1" :size 2}])

(defn symetric? [part] (clojure.string/ends-with? (:name part) "-1"))

(defn new-symetric-part
  [name, number]
  (clojure.string/replace name #"-1$" (str "-" number)))

(defn matching-parts
  [part, quantity]
  (if (symetric? part)
    (reduce (fn [final-parts n]
             (conj final-parts
                   (update part :name #(new-symetric-part % n))))
           [part]
           (range 2 (inc quantity)))
    [part]))

(defn expand-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts, quantity]
   (reduce (fn [final-body-parts part]
            (into final-body-parts (set (matching-parts part quantity))))
          []
          asym-body-parts))

(pprint (expand-body-parts asym-body-parts 3))
