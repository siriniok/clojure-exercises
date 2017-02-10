;;;; Write a function, dec-maker, that works exactly like the function
;;;; inc-maker except with subtraction:
;;;;
;;;; ```
;;;; (def dec9 (dec-maker 9))
;;;; (dec9 10)
;;;; ; => 1
;;;; ```

(defn dec-maker
  "Create a custom decrementor"
  [dec-by]
  #(- % dec-by))

(def dec9 (dec-maker 9))
(println (dec9 10))
