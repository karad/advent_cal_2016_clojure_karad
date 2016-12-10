(ns om-tutorial.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.page :as page]
            [om-tutorial.ui :as ui]))

(defroutes app
           (GET "/" [] (page/html5 [:head]
                                   [:body nil
                                    [:div#app]
                                    (page/include-js "/js/main.js")]))
           (GET "/ssr-1/" [] (page/html5 [:head]
                                         [:body nil
                                          [:div#app nil]
                                          (page/include-js "/js/main.js")]))
           (GET "/ssr-2/" [] (let [component (ui/get-counter)]
                               (page/html5 [:head]
                                           [:body nil
                                            [:div#app nil component]
                                            (page/include-js "/js/main.js")])))
           (route/resources "/")
           (route/not-found "<h1>Page not found</h1>"))






