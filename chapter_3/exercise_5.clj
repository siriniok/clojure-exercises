;;;; Create a function that’s similar to symmetrize-body-parts except that
;;;; it has to work with weird space aliens with radial symmetry. Instead of
;;;; two eyes, arms, legs, and so on, they have five.

(ns exercise-5 (:use clojure.pprint))

(def asym-alien-body-parts [{:name "head" :size 3}
                             {:name "first-eye" :size 1}
                             {:name "first-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "first-shoulder" :size 3}
                             {:name "first-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "first-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "first-kidney" :size 1}
                             {:name "first-hand" :size 2}
                             {:name "first-knee" :size 2}
                             {:name "first-thigh" :size 4}
                             {:name "first-lower-leg" :size 3}
                             {:name "first-achilles" :size 1}
                             {:name "first-foot" :size 2}])

(defn symetric? [part] (clojure.string/starts-with? (:name part) "first-"))

(defn new-symetric-part
  [name, number]
  (clojure.string/replace name #"^first-" (str number "-")))

(defn matching-parts
  [part]
  (if (symetric? part)
    [part,
     (update part :name #(new-symetric-part % "second")),
     (update part :name #(new-symetric-part % "third")),
     (update part :name #(new-symetric-part % "fourth")),
     (update part :name #(new-symetric-part % "fifth"))]
    [part]))

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
   (reduce (fn [final-body-parts part]
            (into final-body-parts (set (matching-parts part))))
          []
          asym-body-parts))

(pprint (symmetrize-body-parts asym-alien-body-parts))
