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



