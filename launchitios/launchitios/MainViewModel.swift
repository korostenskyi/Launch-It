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
    @Published var launches = [Launch]()
    
    private let capsulesinteractor: CapsuleInteractor
    private let launchesInteractor: LaunchesInteractor
    
    init(capsulesinteractor: CapsuleInteractor, launchesInteractor: LaunchesInteractor) {
        self.capsulesinteractor = capsulesinteractor
        self.launchesInteractor = launchesInteractor
    }
    
    func loadData() {
        capsulesinteractor.retrieveCapsules { [weak self] result, error in
            if let result = result {
                self?.capsules.append(contentsOf: result)
            } else if let error = error {
                print(error)
            }
        }
        launchesInteractor.retrieveUpcomingLaunches { [weak self] result, error in
            if let result = result {
                self?.launches.append(contentsOf: result)
            } else if let error = error {
                print(error)
            }
        }
    }
}
