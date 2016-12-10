(ns om-tutorial.component
  (:require
    #?@(:cljs [[om.next :as om :refer-macros [defui]]
               [om.dom :as h]]
        :clj  [[cellophane.next :as om :refer [defui]]
               [cellophane.dom :as h]])))

(defui Counter
  static om/IQuery
  (query [this] [:count])
  Object
  (render [this]
    (let [props (om/props this)
          count (:count props)]
      (h/div nil
             (h/div nil
                    (h/span nil (str "Count by om: " count)))
             (h/div nil
                    (h/button #js {:onClick
                                   #(om/transact! this `[(app/increment {:e ~%})])}
                              "Click me!"))))))

