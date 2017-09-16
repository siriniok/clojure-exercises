;;;; Implement update-in.

(defn my-update-in 
  [m ks f & args]
  (if args
    (assoc-in m ks (apply f (get-in m ks) args))
    (assoc-in m ks (apply f [(get-in m ks)]))))

(def user {:name "James" :age 26})

(println (my-update-in user [:age] inc))
;;=> {:name "James", :age 27}

(println (my-update-in user [:age] + 10))
;;=> {:name "James", :age 36}

(def users [{:name "James" :age 26}  {:name "John" :age 43}])

(println (my-update-in users [1 :age] inc))
;;=> [{:name "James", :age 26} {:name "John", :age 44}]
