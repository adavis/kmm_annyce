//
//  LoadableTodos.swift
//  iosApp
//
//  Created by adavis on 1/11/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

enum LoadableTodos {
    case loading
    case result([Todo])
    case error(String)
}
