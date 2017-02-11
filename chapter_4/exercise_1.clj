;;;; The vampire analysis program you now have is already decades ahead of
;;;; anything else on the market. But how could you make it better? I suggest
;;;; trying the following:

;;;; 1. Turn the result of your glitter filter into a list of names.
;;;; 2. Write a function, append, which will append a new suspect to your
;;;; list of suspects.
;;;; 3. Write a function, validate, which will check that :name and
;;;; :glitter-index are present when you append. The validate function should
;;;; accept two arguments: a map of keywords to validating functions, similar
;;;; to conversions, and the record to be validated.
;;;; 4. Write a function that will take your list of maps and convert it back
;;;; to a CSV string. You’ll need to use the clojure.string/join function.
;;;; Good luck, McFishwich!

(ns fwpd.core)
(def filename "chapter_4/suspects.csv")

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (map :name (filter #(>= (:glitter-index %) minimum-glitter) records)))

(defn csv-serialize-row
  [name glitter-index]
  (str name "," glitter-index "\n"))

(defn csv-serailize-table
  [table]
  (clojure.string/join
    (map #(csv-serialize-row (:name %1) (:glitter-index %1)) table)))

(defn append
  [name glitter-index]
  (spit "chapter_4/suspects.csv"
        (csv-serialize-row name glitter-index) :append true))

;; Usage:
; (append "Bloody Pastor" 14)
; (println (glitter-filter 3 (mapify (parse (slurp filename)))))
(println (csv-serailize-table(mapify (parse (slurp filename)))))
