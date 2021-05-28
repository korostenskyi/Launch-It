//
//  PostsViewModel.swift
//  launchitios
//
//  Created by Roman Korostenskyi on 28.05.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class PostsViewModel : ObservableObject {
    
    @Published var posts = [Post]()
    
    private let interactor: PostInteractor
    
    init(interactor: PostInteractor) {
        self.interactor = interactor
    }
    
    func loadData() {
        interactor.retrievePosts { [weak self] result, error in
            if let result = result {
                self?.posts.append(contentsOf: result)
            } else if let error = error {
                print(error)
            }
        }
    }
}
