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

