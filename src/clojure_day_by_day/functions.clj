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