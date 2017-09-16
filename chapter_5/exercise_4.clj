;;;; Look up and use the update-in function.

(def users [{:name "James" :age 26}  {:name "John" :age 43}])

(println (update-in users [1 :age] inc))
;;=> [{:name "James", :age 26} {:name "John", :age 44}]

(def user {:name "James" :age 26})
(println (update-in user [:age] inc))
;;=> {:name "James", :age 27}

(println (update-in user [:age] + 10))
;;=> {:name "James", :age 36}
