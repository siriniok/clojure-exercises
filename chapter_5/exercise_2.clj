;;;; Implement the comp function.

(defn my-comp
  ([f] f)
  ([f & g]
   (fn [& args]
     (f (apply (apply my-comp g) args)))))



(println ((my-comp inc *) 2 3)) ; 7
(println ((my-comp inc inc *) 2 3)) ; 8
