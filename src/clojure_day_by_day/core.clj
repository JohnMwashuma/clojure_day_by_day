(ns clojure-day-by-day.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;; or Returns the first truthy value
((or + -) 1 2 3)
; 6

;; and Returns the first falsey value or the last truthy value
((and (= 1 1) +) 1 2 3)
; 6

;; or Returns the first element in a sequence
((first [+ 0]) 1 2 3)
; 6


