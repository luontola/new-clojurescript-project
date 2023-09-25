(ns kata.ui
  (:require [kitchen-async.promise :as p]
            [reagent.core :as r]
            [reagent.dom :as dom]))

(comment
  (p/promise [resolve _reject]
    (resolve "example")))

(defn foo [a b]
  (+ a b))


(defonce *data (r/atom "World"))

(defn app []
  [:<>
   [:header
    [:h1 "New ClojureScript Project"]]
   [:main
    [:p "Hello " @*data]]])


(defn init! []
  (if-some [root (.getElementById js/document "root")]
    (dom/render [app] root)))

(init!)

(defn ^:dev/before-load stop [])

(defn ^:dev/after-load start []
  (init!))
