(ns om-tutorial.ui
  (:require
    #?@(:cljs [[om.next :as om :refer-macros [defui]]
               [om.dom :as h]]
        :clj  [[cellophane.next :as om :refer [defui]]
               [cellophane.dom :as h]])
               [om-tutorial.component :as c]
               [om-tutorial.reconciler :as reconciler]))

;; for ssr
(def counter
  (om/add-root! reconciler/reconciler
                c/Counter nil))

(defn get-counter [] (h/render-to-str counter))

