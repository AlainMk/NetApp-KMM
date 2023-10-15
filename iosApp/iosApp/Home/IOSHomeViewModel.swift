//
//  IOSHomeViewModel.swift
//  iosApp
//
//  Created by Alain Paluku on 09/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class IOSHomeViewModel: ObservableObject {
    let viewModel: HomeViewModel = KoinHelper().getHomeViewModel()
    
    @Published var state: HomeUiState = HomeUiState(isLoading: true, users: [], error: nil)
    
    private var handle: DisposableHandle?
    
    func onEvent(event: HomeEvent) {
        self.viewModel.onEvent(event: event)
    }
    
    func startObserving() {
        handle = viewModel.state.subscribe(onCollect: { state in
            if let state = state {
                self.state = state
            }
        })
    }
    
    func dispose() {
        handle?.dispose()
    }
}
