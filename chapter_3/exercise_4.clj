;;;; Write a function, mapset, that works like map except the return value
;;;; is a set:
;;;;
;;;; ```
;;;; (mapset inc [1 1 2 2])
;;;; ; => #{2 3}
;;;; ```

(defn mapset
  [fun sek]
  (into (sorted-set) (map fun sek)))

(println (mapset inc [1 1 2 2]))
