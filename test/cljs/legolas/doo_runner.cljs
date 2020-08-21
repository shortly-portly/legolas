(ns legolas.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [legolas.core-test]))

(doo-tests 'legolas.core-test)

