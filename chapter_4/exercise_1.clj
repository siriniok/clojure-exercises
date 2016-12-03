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
