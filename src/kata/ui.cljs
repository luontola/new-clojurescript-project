(ns kata.ui
  (:require [kitchen-async.promise :as p]
            [reagent.core :as r]
            [reagent.dom :as dom]))

(comment
  (p/promise [resolve _reject]
    (resolve "example")))

(defn foo [a b]
  (+ a b))


(defn counter [start]
  (r/with-let [*counter (r/atom start)
               interval-id (js/setInterval (fn []
                                             (swap! *counter inc))
                                           1000)]
    [:<> "Counter: " @*counter]
    (finally
      (js/clearInterval interval-id))))

(defonce *data (r/atom "World"))

(defn app []
  [:<>
   [:header
    [:h1 "New ClojureScript Project"]]
   [:main
    [:p "Hello " @*data]
    [:p [counter 1]]]])


(defn init! []
  (if-some [root (.getElementById js/document "root")]
    (dom/render [app] root)))

(init!)

(defn ^:dev/before-load stop [])

(defn ^:dev/after-load start []
  (init!))
