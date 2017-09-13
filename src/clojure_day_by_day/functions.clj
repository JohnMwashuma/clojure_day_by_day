(ns clojure-day-by-day.functions)

;; Simple function
(defn greetings
    "Returns a greeting message with the name as the passed arg"
    [name]
    (str "Good morning " name " how is it going."))

(greetings "John")

;; Fuction with a default argument

(defn salutations
    "Returns the salutation of a person or a default salutation"
    ([name salutation]
    (str "Dear " salutation " " name ":"))
    ([name]
    (salutations name "Mr/Mrs")))

(salutations "John" "Mr") ;; Dear Mr John:
(salutations "HR") ;; Dear Mr/Mrs HR: