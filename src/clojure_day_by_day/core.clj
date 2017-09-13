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

(def ingredients
  ["Water" "Wheat Flour" "Sugar" "Salt" "Cream"])

(let [cake (take 4 ingredients)]
      cake)

;=> ("Water" "Wheat Flour" "Sugar" "Salt")

(def 0)

(let [x (inc x)] x) ;; Increments x by 1

;=> 1

(def y [])

(into y (set [:a :a]))
;=>[:a]

;; Regular experessions

;; Looks for strings starting with left-
(re-fing #"^left-" "left-side") 
;=>left-

(re-fing #"^left-" "nleft-side")
;=>nil

;; Reduce function

(reduce +[1 2 3 4])

;(+(+(+ 1 2) 3) 4) Reduce steps
;=>10

