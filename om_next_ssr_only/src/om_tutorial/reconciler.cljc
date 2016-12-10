(ns om-tutorial.reconciler
  (:require
    #?@(:cljs [[om.next :as om :refer-macros [defui]]
               [om.dom :as h]]
        :clj  [[om.next :as om :refer [defui]]
               [om.dom :as h]])
               [om-tutorial.model :as model]))

;;; read
(defmulti read om/dispatch)

(defmethod read :count
  [env key params]
  (let [state (:state env)]
    {:value (:count @state)}))

;;; mutate
(defmulti mutate om/dispatch)

(defmethod mutate 'app/increment
  [env key params]
  (let [state (:state env)]
    {:action #(swap! state update-in [:count] inc)}))

;;; reconciler
(def reconciler
  (om/reconciler
    {:state  model/app-state
     :parser (om/parser {:read   read
                         :mutate mutate})}))