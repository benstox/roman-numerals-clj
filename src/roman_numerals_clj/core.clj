(ns roman-numerals-clj.core
  (:gen-class))

(def values {
  \m 1000
  \d 500
  \c 100
  \l 50
  \x 10
  \v 5
  \u 5
  \i 1
  \j 1})

(def negatives #{
  [\c \m]
  [\c \d]
  [\x \c]
  [\x \l]
  [\i \x]
  [\i \v]
  [\i \u]
  [\j \x]
  [\j \v]
  [\j \u]})


(defn -main
  "Pass in a number in Roman numerals and it will print it in Arabic numerals."
  [numeral]
  (println numeral)
  (let [numeral-lower (clojure.string/lower-case numeral)
        positive-value (reduce #(+ (get values %2 0) %1) 0 numeral-lower)
        pairs (map vector numeral-lower (rest numeral-lower))
        pairs-to-subtract (filter negatives pairs)
        negative-value (reduce + (map #(->> % first (get values) (* 2)) pairs-to-subtract))
        final-value (- positive-value negative-value)]
    (println final-value)
    )
)