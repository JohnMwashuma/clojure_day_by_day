(ns clojure-day-by-day.control_flow)
;; Clojure control flow

;; Check if something is true
(true? true)
;=>true

(true? false)
;=>false

(= '(:drinkme :bottle) [:drinkme :bottle])
;=>true

;; Check if something is false
(false? false)
;=>true

(false? true)
;=>false

;; Testing if something is not there
(nil? nil)
;=>true

(nil? 1)
;=>false

;; Checking if something is not true
; not returns true if the parameter is a logi-cal false; otherwise, it returns false

(not true)
;=>false

(not false)
;=>true

(not nil)
;=>true

(not= 1 2)
;=>true

;;  Testing if something is true for every element in the collection
(every? odd? [1 3 5])
;=>true

(every? odd? [1 2 3 5])
;=>false

(defn check_poison? [x] (= x :eatable))

(every? check_poison? [:eatable :poison])
;=>false

(every? check_poison? [:eatable :eatable])
;=>true

(every? (fn[x] (= x :eatable)) [:eatable :eatable])
;=>true

(every? #(= % :poison) [:eatable :eatable])
;=>false

(not-any? #(= % :poison) [:eatable :eatable])
;=>true