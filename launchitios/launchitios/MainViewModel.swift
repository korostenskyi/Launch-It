//
//  PostsViewModel.swift
//  launchitios
//
//  Created by Roman Korostenskyi on 28.05.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import shared

class MainViewModel : ObservableObject {
    
    @Published var capsules = [Capsule]()
    
    private let interactor: CapsuleInteractor
    
    init(interactor: CapsuleInteractor) {
        self.interactor = interactor
    }
    
    func loadData() {
        interactor.retrieveCapsules { [weak self] result, error in
            if let result = result {
                self?.capsules.append(contentsOf: result)
            } else if let error = error {
                print(error)
            }
        }
    }
}
