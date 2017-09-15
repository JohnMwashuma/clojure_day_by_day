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

;; Passing rest args using &
(defn fav
  "Return one's favorite things"
  [name & things]
  (str "Hi "name", here are my favorite things: "
  (clojure.string/join ", " things)))

(fav "Mwashuma" "Movies" "gum" "series" "clojure")

;; Destructuring
;; Getting the first element in a vector
(defn my-first
    "Returns the first element in a vector"
    [[first-thing]]
    first-thing)

(my-first ["John" "Mwashuma" "Stive"])

; => "John"

(defn find_monny
    "Destructors a map values"
    [{lat :lat lng :lng}]
    (str "Monny Latitude: " lat " and Longitude: " lng ))

(find_monny {:lat 28.22 :lng 81.33})

(defn find_treasure
    "Destructors a map with the keys method"
    [{:keys [lat lng]}]
    (str "The treasure Latitude is: " lat " and Longitude is: " lng))

(find_treasure {:lat 34.22 :lng 22.33})

(defn find_all_treasure
    "Destructors a map with the keys method"
    [{:keys [lat lng] :as location}]
    (str "All treasure Latitude and Longitude are: " location))

(find_all_treasure {:lat 34.22 :lng 22.33})

;; Anonymous Functions

(map (fn [name] (str "Hi, " name))
      ["John"])

; => ("Hi, John")

(def my_special_division (fn [x] (/ 20 x)))

(my_special_division 5)

(#(* % 3) 8) ; => 24

(map #(str "Hi, " %) ["Mwashuma"]) ;=> ("Hi, Mwashuma")

(#(str "Hi, am " % " " %2) "John" "Mwashuma") ;=> "Hi, am John Mwashuma"

;; Take function
; It takes a number and a sequence

(take 3 [1 2 3 4 5 6])
;=> [1 2 3]

(drop 3 [1 2 3 4 5 6 7 8 9 10])
; => (4 5 6 7 8 9 10)

;take-while
(def bakery_orders [
  {:month 1 :name "Queen Cakes" :quantity 100}
  {:month 2 :name "Pizza's" :quantity 39}
  {:month 3 :name "Wedding Cakes" :quantity 20}
  {:month 4 :name "Breads" :quantity 200}
  {:month 5 :name "Yoghurt" :quantity 50}
])

(take-while #(< (:month %) 3) bakery_orders)
;=>({:month 1, :name "Queen Cakes", :quantity 100} {:month 2, :name "Pizza's", :quantity 39})

(drop-while #(< (:month %) 3) bakery_orders)
;=>({:month 3, :name "Wedding Cakes", :quantity 20} {:month 4, :name "Breads", :quantity 200} {:month 5, :name "Yoghurt", :quantity 50})

; Takes anything that is less than 5 and drops anything less than 3
(take-while #(< (:month %) 5) (drop-while #(< (:month %) 3) bakery_orders))
;=>({:month 3, :name "Wedding Cakes", :quantity 20} {:month 4, :name "Breads", :quantity 200})

;; Filter
(filter #(> (:month %) 3) bakery_orders)
;=>({:month 4, :name "Breads", :quantity 200} {:month 5, :name "Yoghurt", :quantity 50})

;; Some
(some #(> (:month %) 4) bakery_orders)
;=>true

(some #(and (> (:month %) 4) %) bakery_orders)
;=>{:month 5, :name "Yoghurt", :quantity 50}

(some #(> (:month %) 5) bakery_orders)
;=>nil

;; Infinite Sequences

(concat (take 2 (repeat "Yeah!..")) ["Got it!"])
;=>("Yeah!.." "Yeah!.." "Got it!")

(take 5 (repeatedly (fn [] (rand-int 10))))
;=>(1 3 0 2 3)

(cons 0 '(1 2 3))
;=>(0 1 2 3)

;; Collection Abstraction

(empty? [])
;=>true

(empty? [1 2])
;=>false

(map identity {:name "John"})
;=>{[:name "John"]}

(into {} (map identity {:name "John"}))
;=>{:name "John"}

(into [] (map identity [:name :description]))
;=>[:name :description]

;; Changes a vector to a set
(into #{} (map identity [:john :john]))
;=>#{:john}

(into {:firstName "John"} [[:lastName "Mwashuma"]] )
;=>{:firstName "John", :lastName "Mwashuma"}

(into {:firstName "John"} [ {:middleName "Kirigha"} {:lastName "Mwashuma"}])
;=>{:firstName "John", :middleName "Kirigha", :lastName "Mwashuma"}

(into ["John"] '("Kirigha" "Mwashuma"))
;=>["John" "Kirigha" "Mwashuma"]

(conj [0] 1 2 3)
;=>[0 1 2 3]

(conj {:name "John"} [:age "24"])
;=>{:name "John", :age "24"}

(conj {:name "John"} {:age "24"})
;=>{:name "John", :age "24"}

;; Function Functions
; Apply

(max 1 2 3)
;=> 3
(max [1 2 3])
;=> [1 2 3]

(apply max [1 2 3])
;=>3

;; Applying apply to conj
(defn my_conj
[target nums]
(apply conj target nums))

(my_conj [1] [2 3 4 5])
;=>[1 2 3 4 5]

;; Partial 

(def add2 (partial + 8))
(add2 2)
;=>10

(def my_new_conj (partial ["John"]))
(my_new_conj "Kirigha" "Mwashuma")
;=>["John" "Kirigha" "Mwashuma"]

;; Sets
;Union
(clojure.set/union #{:t :u} #{:u :v})
;=>#{:v :t :u}

;Difference
(clojure.set/difference #{:t :u} #{:u :v})
;=>#{:t}

;Intersection
(clojure.set/intersection #{:t :u} #{:u :v})
;=>#{:u}

(get #{:t :u} :t)
;=>#{:t}

(contains? #{:t :u} :t)
;=>true

(conj #{:t :u} :v)
;=>#{:t :u :v}

(disj #{:t :u} :u)
;=>#{:t}