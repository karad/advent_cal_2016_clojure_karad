(ns om-tutorial.script
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om-tutorial.component :as c]
            [om-tutorial.reconciler :as reconciler]
            [figwheel.client :as figwheel :include-macros true]))

(declare mount)

(enable-console-print!)

(figwheel/watch-and-reload
  :websocket-url "ws://192.168.33.10:3449/figwheel-ws"
  :jsload-callback mount)

(defn mount []
  (om/add-root! reconciler/reconciler
                c/Counter (gdom/getElement "app")))

(mount)