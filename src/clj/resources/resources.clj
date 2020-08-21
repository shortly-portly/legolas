(ns resources.resources)

(def user-resource
  {:resource :user
   :table :users
   :sql
   {:index {:select [:first_name] :from [:users]}}

   :view
   {:index
    {:fields [{:path :first_name
               :label "First Name"
               :type :text}

              {:path :last_name
               :label "Last Name"
               :type :text}

              {:path :email
               :label "Email"
               :type :text}]}}})
