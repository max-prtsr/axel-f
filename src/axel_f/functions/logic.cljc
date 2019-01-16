(ns axel-f.functions.logic
  (:require [axel-f.macros :refer [def-excel-fn]]))

(def and*
  ^{:desc "Returns true if all of the provided arguments are logically true, and false if any of the provided arguments are logically false."
    :args [{:desc "Returns true if all of the provided arguments are logically true, and false if any of the provided arguments are logically false."}
           {:desc "An expression or reference to some logical value, i.e. TRUE or FALSE, or can be coerced to a logical value."
            :opt true
            :repeatable true}]}
  (fn [& args]
    (every? identity args)))

(def not*
  ^{:desc "Returns the opposite of a logical value - `NOT(TRUE)` returns `FALSE`; `NOT(FALSE)` returns `TRUE`."
    :args [{:desc "An expression or reference holding an expression that represents some logical value, i.e. TRUE or FALSE."}]}
  (fn [logical-expression]
    (clojure.core/not logical-expression)))

(def or*
  ^{:desc "Returns true if any of the provided arguments are logically true, and false if all of the provided arguments are logically false."
    :args [{:desc "An expression or reference to some logical value, i.e. TRUE or FALSE, or can be coerced to a logical value."}
           {:desc "More expressions that evaluate to logical values."
            :opt true
            :repeatable true}]}
  (fn [& args]
    (boolean (some identity args))))

(def-excel-fn
  "AND" and*
  "OR" or*
  "NOT" not*)
