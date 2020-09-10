(ns resources.resources)

(def user-resource
  {:resource :user
   :table :users

;; Thoughts on schemas - so I don't forget.
;; Field level validation - can define a specific schema path OR default to data-path as the schema path - possible to return nil meaning there is no
;; specific validation for this field
;;
;; A form widget can also have a schema in wich you can define cross field validations.
;; A row in a table can have a schema allowing for row validation - can you have on-blur for a table row? - might want to consider renaming :fields to :row
;; Could even possibly have on-blur for the whole table itslef allowing for full table validation.
;;
;; A field NOT in the schema is assumed to be string with no validation.

   :schema
   [:map
   [:user
    [:map

    [:first_name int?]
    [:last_name string?]
    [:email string?]]]]

   :view
   {:index {:type :table
             :path :user

             :fields
             [{:type :cell
               :path :first_name}

              {:type :cell
               :path :last_name
               :label "Last Name"}

              {:type :cell
               :path :email
               :label "Email"}

              {:type :actions
               :path :id
               :label "Actions"
               :resource :user
               :actions [:show :edit :delete]}]}

    :show {:type :two-columns
            :path :user

            :column-1
            [{:type :card

              :fields
              [{:type :text
                :path :first_name
                :label "First Name"}

               {:type :text
                :path :last_name
                :label "Last Name"}]}]

            :column-2
            [{:type :card
              :fields

              [{:type :text
                :path :email
                :label "Email"}]}]}

    :edit {:type :two-columns
            :path :user

            :column-1
            [{:type :card

              :fields
              [{:type :text-input
                :path :first_name
                :label "First Name"}

               ]}]

            :column-2
            [{:type :card
              :fields

              [{:type :text
                :path :email
                :label "Email"}]}]}}})
