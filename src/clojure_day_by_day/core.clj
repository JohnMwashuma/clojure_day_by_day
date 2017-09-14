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

(reduce (fn [new-map [key val]]
        (assoc new-map key (inc val)))
        {}
        {:max 6 :min 9})
;=>{:max 7 :min 10}

(reduce (fn [new-map [key val]]
        (if (> val 4)
        (assoc new-map key val)
        new-map))
        {}
        {:John_height 4.9 :Stive_height 3.9})
;=>{:John_height 4.9}

;; Assoc takes a map, a key and a value e.g
(assoc {} :max 30)
;=>{:max 30}

;; Maps

(defn title_iz [title]
    (str title " is the guru of clojure."))

(map title_iz ["John" "Roy" "Kip"])

;=> ("John is the guru of clojure." "Roy is the guru of clojure." "Kip is the guru of clojure.")

(map title_iz '("John" "Roy"))

;=> ("John is the guru of clojure." "Roy is the guru of clojure.")

(map title_iz #{"John" "Roy"})

;=> ("John is the guru of clojure." "Roy is the guru of clojure.")

(def names [
  {:firstName "John" :lastName "Mwashuma"}
  {:firstName "Silvan" :lastName "Mwashuma"}
  {:firstName "Harry" :lastName "Mwashuma"}
  {:firstName "Daniel" :lastName "Mwashuma"}
])

(map :firstName names)
;=> ("John" "Silvan" "Harry" "Daniel")

(defn sum [stats]
  (str "The sum is: " (#(reduce + stats))))

(defn avrg [stats]
  (str "The average is: " (#(/ (reduce + stats) (count stats)))))

(avrg [3 7 20])

;; Seq

(seq '(1 2 3))
;=> (123)
(seq #{1 2 3})
;=> (123)
(seq [1 2 3])
;=> (123)