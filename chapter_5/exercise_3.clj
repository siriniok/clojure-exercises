;;;; Implement the assoc-in function. Hint: use the assoc function and define
;;;; its parameters as [m [k & ks] v].

(defn my-assoc-in
  [m [k & ks] v]
   (if ks
     (assoc m k (my-assoc-in m ks v))
     (assoc m k v)))

(println (my-assoc-in {} [:cookie :monster :vocals] "Finntroll"))
; => {:cookie {:monster {:vocals "Finntroll"}}}

(println (my-assoc-in {} [1 :connections 4] 2))
; => {1 {:connections {4 2}}}
