//
//  CapsulesViewModel.swift
//  launchitios
//
//  Created by Roman Korostenskyi on 02.06.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import shared

class CapsulesViewModel: ObservableObject {
    
    @Published var capsules = [Capsule]()
    
    private let capsulesinteractor: CapsuleInteractor
    
    init(capsulesinteractor: CapsuleInteractor) {
        self.capsulesinteractor = capsulesinteractor
    }
    
    func loadData() {
        capsulesinteractor.retrieveCapsules { [weak self] result, error in
            if let result = result {
                self?.capsules.append(contentsOf: result)
            } else if let error = error {
                print(error)
            }
        }
    }
}
