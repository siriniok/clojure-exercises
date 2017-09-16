;;;; Use the list function, quoting, and read-string to create a list that,
;;;; when evaluated, prints your first name and your favorite sci-fi movie.

(def list-list (list println "Vlad" "Mr.Nobody"))

(eval list-list)

(def quoted-list '(println "Vlad" "Mr.Nobody"))

(eval quoted-list)

(def read-string-list (read-string "(println \"Vlad\" \"Mr.Nobody\")"))

(eval read-string-list)
