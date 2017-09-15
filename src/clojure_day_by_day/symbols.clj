(ns clojure-day-by-day.symbols)

;; Symbols

(def developer "John Mwashuma") ;developer is a symbol

;;  bindings of let are in a vector form. It expects pairs of symbol and values.
(let [developer "Roy Rutto"] developer)
;=>"Roy Rutto"

developer
;=>"John Mwashuma"

;; What happens in a let, stays in the let.

(let [company "Ona" employees 23] [company employees])
;=>["Ona" 23]

company
;=>CompilerException java.lang.RuntimeException: Unable to resolve symbol: company in this context

;; Implementing require, set and let

(require '[clojure.set :as s])

(defn share_name [list1 list2]
        (let [my_names (set list1)
              other_names (set list2)
              common_name (s/intersection my_names other_names)]
              (str "Our common name is: " common_name)))

(share_name [:john :Mwashuma][:silvan :Mwashuma])
;=>"Our common name is: #{:Mwashuma}"

